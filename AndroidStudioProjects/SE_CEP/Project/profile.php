<?php 

include "dbconnect.php";

//Checking if any error occured while connecting
if (mysqli_connect_errno()) {
echo "Failed to connect to MySQL: " . mysqli_connect_error();
die();
}


//creating a query
$stmt = $conn->prepare("SELECT `First Name`, `Email`, `CNIC`, `Number` FROM `User_Info`");

//executing the query 
$stmt->execute();

//binding results to the query 
$stmt->bind_result($name,$email,$cnic,$number);

$products = array(); 

//traversing through all the result 
while($stmt->fetch()){
$temp = array();
$temp['name'] = $name;
$temp['email'] = $email;
$temp['cnic'] = $cnic;
$temp['number'] = $number;

array_push($products, $temp);
}

//displaying the result in json format 
echo json_encode($products);