package com.rsic.datatools.pipeline.template.models.inputs

case class HistoricalPrices(date: Option[String],
                            symbol: Option[String],
                            open: Option[Double],
                            high: Option[Double],
                            low: Option[Double],
                            adj_close: Option[Double],
                            volume: Option[Long])
