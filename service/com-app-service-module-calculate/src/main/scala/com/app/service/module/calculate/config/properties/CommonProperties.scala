package com.app.service.module.calculate.config.properties

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class CommonProperties {

  @Autowired
  var spark: SparkProperties = _

  def getSparkProperties: SparkProperties = spark

  def setSparkProperties(spark: SparkProperties): Unit = this.spark = spark
}
