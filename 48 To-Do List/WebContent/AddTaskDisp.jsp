<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

  <form role="form" action="AddTask" method="post">
    <div class="form-group">
      <label for="taskname">Task</label>
      <input type="text" class="form-control" id="taskname" name="taskname" placeholder="Enter task">
    </div>
    <div class="form-group">
      <label for="taskdate">Due Date</label>
      <input type="date" class="form-control" id="taskdate" name="taskdate" placeholder="Enter duedate (mm\dd\yy)">
    </div>
   
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
