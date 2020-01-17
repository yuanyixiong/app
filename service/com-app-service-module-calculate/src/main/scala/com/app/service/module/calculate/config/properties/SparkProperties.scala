package com.app.service.module.calculate.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.{Configuration, PropertySource}

@Configuration
@PropertySource(Array("classpath:spark.properties"))
@ConfigurationProperties(prefix = "spark")
class SparkProperties {

  /**
    * 是否启用本地模式
    */
  private var localIf: String = _

  /**
    * 应用的名称
    */
  private var appName: String = _

  /**
    * 主节点
    */
  private var master: String = _

  /**
    * 根目录
    */
  private var home: String = _

  /**
    * 数据拉去时间间隔,单位秒
    */
  private var duration: Int = _

  /**
    * driver使用的内存数量
    */
  private var driverMemory: String = _

  /**
    * worker使用的内存数量
    */
  private var workerMemory: String = _

  /**
    * executor使用的内存数量
    */
  private var executorMemory: String = _


  def getLocalIf: String = localIf

  def setLocalIf(localIf: String): Unit = this.localIf = localIf

  def getAppName: String = appName

  def setAppName(appName: String): Unit = this.appName = appName

  def getMaster: String = master

  def setMaster(master: String): Unit = this.master = master

  def getHome: String = home

  def setHome(home: String): Unit = this.home = home

  def getDuration: Int = duration

  def setDuration(duration: Int): Unit = this.duration = duration

  def getDriverMemory: String = driverMemory

  def setDriverMemory(driverMemory: String): Unit = this.driverMemory = driverMemory

  def getWorkerMemory: String = workerMemory

  def setWorkerMemory(workerMemory: String): Unit = this.workerMemory = workerMemory

  def getExecutorMemory: String = executorMemory

  def setExecutorMemory(executorMemory: String): Unit = this.executorMemory = executorMemory

}
