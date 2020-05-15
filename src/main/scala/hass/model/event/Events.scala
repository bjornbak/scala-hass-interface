package hass.model.event

import com.github.nscala_time.time.Imports
import com.github.nscala_time.time.Imports.DateTime
import hass.model.service._
import hass.model.state.EntityState
import play.api.libs.json.JsValue

sealed trait Event {
  def timeFired: DateTime

  def origin: String
}

case class UnknownEvent(jsValue: JsValue, timeFired: DateTime, origin: String) extends Event

case class StateChangedEvent[S <: EntityState[_]](entity_id: String, oldState: S, newState: S, timeFired: DateTime, origin: String) extends Event

case class ServiceCallEvent(service: Service, timeFired: DateTime, origin: String) extends Event

trait ConnectionEvent extends Event {
  private val _timeFired = Imports.DateTime.now()

  override def timeFired: Imports.DateTime = _timeFired

  override def origin: String = "INTERNAL"
}

case object ConnectionOpenEvent extends ConnectionEvent
case object ConnectionClosedEvent extends ConnectionEvent




