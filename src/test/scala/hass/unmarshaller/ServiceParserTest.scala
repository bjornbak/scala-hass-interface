package hass.unmarshaller

import hass.model.service.SwitchTurnService
import hass.model.state.ground.Off
import org.scalatest.funsuite.AnyFunSuite
import play.api.libs.json.{JsValue, Json}

class ServiceParserTest extends AnyFunSuite {
  val service1: JsValue = Json.parse("{\"domain\":\"switch\",\"service\":\"turn_off\",\"service_data\":{\"entity_id\":[\"switch.kitchen\",\"switch.bed\"]}}")
  test("Parse result 1") {
    ServiceUnmarshaller(service1) match {
      case Some(SwitchTurnService(ids, Off)) =>
        assert(ids.contains("kitchen"))
        assert(ids.contains("bed"))
      case _ => fail()
    }
  }

}
