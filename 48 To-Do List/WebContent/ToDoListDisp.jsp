<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>
  <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.0/css/bootstrap-toggle.min.css" rel="stylesheet">
</head>
<body>

 <form role="form" action="Update" method="post">
 
<div class="container">
  <h2>To Do</h2>       
  <table class="table">
    <thead>
      <tr>
        <th>Completed?</th>
        <th>Task</th>
        <th>Due Date</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${status}</td>
        <td>${task}</td>
        <td>${duedate}</td>
      </tr>
      <tr>
    </tbody>
  </table>
</div>

 <button type="submit" class="btn btn-default">Submit</button>

</form>

<br><br>
 <form role="form" action="Completed" method="post">
    <button type="submit" class="btn btn-default">View completed tasks</button>    
</form>


<br><br>
 <form role="form" action="AddTaskDisp.jsp" >
    <button type="submit" class="btn btn-default">Add new Task</button>    
</form>




</body>
</html>
