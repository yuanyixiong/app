package com.app.service.module.calculate.config.sprak


import com.app.service.module.calculate.config.properties.CommonProperties
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.{ConditionalOnBean, ConditionalOnClass, ConditionalOnMissingBean}
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.{Bean, Configuration, PropertySource}


@Configuration
@PropertySource(Array("classpath:spark.properties"))
@ConfigurationProperties(prefix = "spark")
@ConditionalOnBean(Array(classOf[CommonProperties]))
@ConditionalOnClass(Array(classOf[SparkConf], classOf[SparkSession], classOf[SparkContext], classOf[StreamingContext], classOf[HiveContext]))
class SparkConfig {

  @Autowired
  private var commonProperties: CommonProperties = _

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean(Array(classOf[CommonProperties]))
  def sparkConf: SparkConf = {
    var sparkProperties = commonProperties.getSparkProperties;
    if (sparkProperties.getLocalIf.toBoolean)
      new SparkConf().setAppName(sparkProperties.getAppName).setMaster(sparkProperties.getMaster)
    else
      new SparkConf().setAppName(sparkProperties.getAppName)
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean(Array(classOf[SparkConf], classOf[CommonProperties]))
  def sparkSession: SparkSession = {
    var sparkProperties = commonProperties.getSparkProperties;
    if (sparkProperties.getLocalIf.toBoolean)
      SparkSession.builder().config(sparkConf).getOrCreate()
    else
      SparkSession.builder().config(sparkConf)
        .config("spark.driver.memory", sparkProperties.getDriverMemory)
        .config("spark.worker.memory", sparkProperties.getWorkerMemory)
        .config("spark.executor.memory", sparkProperties.getExecutorMemory)
        .config("spark.serializer", classOf[KryoSerializer].getName)
        .getOrCreate()
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean(Array(classOf[SparkSession]))
  def sparkContext: SparkContext = sparkSession.sparkContext

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean(value = Array(classOf[SparkContext], classOf[CommonProperties]))
  def sparkStreaming: StreamingContext = new StreamingContext(sparkContext, Seconds(commonProperties.getSparkProperties.getDuration))

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean(value = Array(classOf[SparkContext]))
  def hiveContext: HiveContext = new HiveContext(sparkContext);
}