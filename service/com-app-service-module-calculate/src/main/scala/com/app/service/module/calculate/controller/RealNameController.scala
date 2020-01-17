package com.app.service.module.calculate.controller

import com.app.service.module.calculate.service.RealNameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("/real/name"))
class RealNameController {

  @Autowired
  private var realNameService: RealNameService = _

  @GetMapping(path = Array("/do/task/01"))
  def doTask_01(): String = {
    realNameService.doTask_01()
    "over"
  }

  @GetMapping(path = Array("/do/task/02"))
  def doTask_02(): String = {
    realNameService.doTask_02()
    "over"
  }

  @GetMapping(path = Array("/do/task/03"))
  def doTask_03(): String = {
    realNameService.doTask_03()
    "over"
  }

  @GetMapping(path = Array("/do/task/04"))
  def doTask_04(): String = {
    realNameService.doTask_04()
    "over"
  }
}