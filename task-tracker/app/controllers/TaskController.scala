package controllers

import javax.inject._
import models.Task
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class TaskController @Inject()(
    cc: ControllerComponents
) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request =>
    Redirect(routes.TaskController.tasks)
  }

  def tasks = Action { implicit request =>
    Ok(views.html.index(Task.all))
  }

  def newTask = Action(parse.formUrlEncoded){ implicit request =>
    request.body.get("taskName").map(_.headOption.map(Task.add(_)))
    Redirect(routes.TaskController.index)

  }

  def deleteTask(id: Int) = Action { implicit request =>
    Task.delete(id)
    Ok
  }

}
