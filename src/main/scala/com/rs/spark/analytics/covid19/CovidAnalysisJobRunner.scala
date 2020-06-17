package com.rs.spark.analytics.covid19

import org.apache.spark.SparkFiles
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.functions._
import scalax.chart.api._

object CovidAnalysisJobRunner extends App {
  val spark = SparkSession.builder()
              .master("local[*]")
              .appName("Covid Analysis")
              .getOrCreate()
  spark.sparkContext.addFile("https://covid.ourworldindata.org/data/owid-covid-data.csv")
  val rawDataDf = spark.read
                  .option("header", "true")
                  .csv("file://" + SparkFiles.get("owid-covid-data.csv"))
  val lastTenDays = rawDataDf
                    .filter(col("iso_code") === "IND")
                    .orderBy(desc("date"))
                    .limit(10)
  lastTenDays.write.format("csv")
                    .option("header", "true")
                    .save("src/main/resources/result.csv")

  Thread.sleep(Long.MaxValue)

}

