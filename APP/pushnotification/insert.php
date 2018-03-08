<?php

require "nt.php";
$push_token = $_POST["push_token"];
$sql = "insert into pushnoti_info values('".$push_token."');";
mysqli_query($con,$sql);
mysqli_close($con);


?>