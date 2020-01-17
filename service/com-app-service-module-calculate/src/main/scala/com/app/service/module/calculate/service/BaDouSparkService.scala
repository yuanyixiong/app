package com.app.service.module.calculate.service

import com.app.service.module.calculate.common.BaseService


trait BaDouSparkService extends BaseService {

  /**
    * 自己虚拟机的hadoop集群
    */
  def doTask_01(): Unit

}
