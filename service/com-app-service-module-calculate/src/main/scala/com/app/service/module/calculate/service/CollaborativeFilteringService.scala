package com.app.service.module.calculate.service

import com.app.service.module.calculate.common.BaseService

/**
  * 协同过滤
  */
trait CollaborativeFilteringService extends BaseService {

  def doTask_01(filrUrl: String): Unit
}
