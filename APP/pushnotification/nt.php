<?php

$host = "localhost";
$db_user = "root";
$db_password = "";
$db_name = "pushnoti_dp";

$con = mysqli_connect($host,$db_user,$db_password,$db_name);
if($con)
	echo "Connection success....";
else
	echo "Connection error....";

?>
