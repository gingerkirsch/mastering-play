package models

case class Task(id: Int, name: String)

object Task {
  private var taskList: List[Task] = List()

  def all: List[Task] = taskList

  def add(taskName: String): Unit = {
    val newId: Int = taskList.size + 1
    taskList = taskList ++ List(Task(newId, taskName))
  }

  def delete(taskId: Int): Unit = {
    taskList = taskList.filterNot(task => task.id == taskId)
  }
}
