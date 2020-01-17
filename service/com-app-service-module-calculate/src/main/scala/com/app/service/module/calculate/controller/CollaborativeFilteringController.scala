package com.app.service.module.calculate.controller

import com.app.service.module.calculate.service.CollaborativeFilteringService
import com.common.core.constant.ApiPathConstant.PATH_PREFIX_V1
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}


@RestController
@RequestMapping(Array(PATH_PREFIX_V1 + "/collaborative/filtering"))
class CollaborativeFilteringController {

  @Autowired
  private var collaborativeFilteringService: CollaborativeFilteringService = _

  @GetMapping(path = Array("/do/task/01"))
  def doTask_01(@RequestParam(value = "filrUrl") filrUrl: String): String = {
    collaborativeFilteringService.doTask_01(filrUrl);
    "over"
  }

}
