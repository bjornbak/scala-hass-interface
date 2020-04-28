package hass.model.state

import com.github.nscala_time.time.Imports.DateTime
import play.api.libs.json.{JsObject, Reads}

trait EntityState[T] {
  def entity_name: String

  def entity_domain: String

  def entity_id: String = s"$entity_domain.$entity_name"

  def lastChanged: DateTime

  def lastUpdated: DateTime

  def state: T

  def attributes: Option[JsObject]

  def attribute[A: Reads](name: String): Option[A] =
    attributes.flatMap(_.fields.collectFirst { case (`name`, value) => value }).map(_.as[A])
}

object EntityState {
  def unapply(arg: EntityState[_]): Option[(String, Any, DateTime, DateTime, Option[JsObject])] =
    Some(arg.entity_id, arg.state, arg.lastChanged, arg.lastUpdated, arg.attributes)
}

case class UnknownEntityState(override val entity_id: String, state: String, lastChanged: DateTime, lastUpdated: DateTime, attributes: Option[JsObject]) extends EntityState[String] {
  override def entity_name: String = entity_id.split('.')(1)

  override def entity_domain: String = entity_id.split('.')(0)
}










