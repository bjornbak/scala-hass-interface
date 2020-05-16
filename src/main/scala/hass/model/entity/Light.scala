package hass.model.entity


import hass.controller.Hass
import hass.model.MetaDomain
import hass.model.Types.DomainType
import hass.model.service.LightTurnService
import hass.model.state._
import hass.model.state.ground.{TurnAction, TurnState}

object Light extends MetaDomain {
  val domain: DomainType = "light"

  def apply()(implicit light_name: sourcecode.Name, hass: Hass): Light = Light(light_name.value)(hass)
}


case class Light(entity_name: String)(override implicit val hass: Hass)
  extends StatefulEntity[TurnState, LightState]() with Light.Domain
    with Turnable[LightTurnService] {
  override def service(turn: TurnAction): LightTurnService = LightTurnService(Seq(entity_name), turn)
}
