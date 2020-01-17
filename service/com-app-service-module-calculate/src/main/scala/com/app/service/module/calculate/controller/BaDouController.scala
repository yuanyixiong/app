package com.app.service.module.calculate.controller

import com.app.service.module.calculate.service.BaDouSparkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("/ba/dou"))
class BaDouController {

  @Autowired
  private var baDouSparkService: BaDouSparkService = _

  @RequestMapping(method = Array(RequestMethod.GET), path = Array("/do/task/01"))
  def doTask_01(): String = {
    baDouSparkService.doTask_01()
    "over"
  }
}