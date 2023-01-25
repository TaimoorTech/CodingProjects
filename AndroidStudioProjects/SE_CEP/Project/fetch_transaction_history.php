<?php 

    include "dbconnect.php";
 
    //Checking if any error occured while connecting
    if (mysqli_connect_errno()) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    die();
    }

 
    //creating a query
    $stmt = $conn->prepare("SELECT `Id`, `Date`, `Time`,  `Method`, `Amount` FROM `transaction_history`");
 
    //executing the query 
    $stmt->execute();
 
    //binding results to the query 
    $stmt->bind_result($id, $date, $time, $method, $amount);
 
    $info = array(); 
 
    //traversing through all the result 
    while($stmt->fetch()){
    $temp = array();
    $temp['id'] = $id; 
    $temp['date'] = $date; 
    $temp['time'] = $time;
    $temp['method'] = $method;
    $temp['amount'] = $amount; 
    array_push($info, $temp);
    }
 
    //displaying the result in json format 
    echo json_encode($info);

?>