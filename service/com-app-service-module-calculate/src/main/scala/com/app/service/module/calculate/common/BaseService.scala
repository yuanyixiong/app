package com.app.service.module.calculate.common

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.streaming.StreamingContext
import org.springframework.beans.factory.annotation.Autowired

/**
  * 业务基类
  */
class BaseService {

  /**
    * sparkContext
    */
  @Autowired
  protected var sparkContext: SparkContext = _

  /**
    * sparkSql
    */
  @Autowired
  protected var sparkSql: SparkSession = _

  /**
    * sparkStreaming
    */
  @Autowired
  protected var sparkStreaming: StreamingContext = _

  /**
    * hive
    */
  @Autowired
  protected var hive: HiveContext = _
}
