package com.app.service.module.calculate.service.impl


import com.app.service.module.calculate.service.BaDouSparkService
import org.springframework.stereotype.Service

@Service
class BaDouSparkServiceImpl extends BaDouSparkService {

  override def doTask_01(): Unit = {
    //hive --service metastore

    val aisles = sparkSql.sql("select * from badou.aisles").where("aisle_id is not null")
    val departments = sparkSql.sql("select * from badou.departments").where("department_id is not null")
    val prior = sparkSql.sql("select * from badou.order_products_prior").where("order_id is not null")
    val train = sparkSql.sql("select * from badou.order_products_train").where("order_id is not null")
    val orders = sparkSql.sql("select * from badou.orders").where("order_id is not null")
    val products = sparkSql.sql("select * from badou.products").where("product_id is not null")

    aisles.show(10)
    departments.show(10)
    prior.show(10)
    train.show(10)
    orders.show(10)
    products.show(10)
  }

}
