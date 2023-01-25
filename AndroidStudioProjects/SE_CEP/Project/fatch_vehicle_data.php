<?php 

    include "dbconnect.php";
 
    //Checking if any error occured while connecting
    if (mysqli_connect_errno()) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    die();
    }

 
    //creating a query
    $stmt = $conn->prepare("SELECT `Vehicle Class`, `Purchase Type`, `Ownership Status`, `Price`, `Seating Capacity`,
    `Import/Purchase Date`, `Engine Size` FROM `Vehicle_Tax`");
 
    //executing the query 
    $stmt->execute();
 
    //binding results to the query 
    $stmt->bind_result($vehicle_class, $purchase_type, $ownweship_status, $price, 
    $seating_capacity, $import_purchase_date, $engine_size);
 
    $info = array(); 
 
    //traversing through all the result 
    while($stmt->fetch()){
    $temp = array();
    $temp["vehicle_class"] = $vehicle_class;
    $temp["purchase_type"] = $purchase_type;
    $temp["ownership_status"] = $ownweship_status;
    $temp["price"] = $price;    
    $temp["seating_capacity"] = $seating_capacity;
    $temp["import_purchase_date"] = $import_purchase_date;
    $temp["engine_size"] = $engine_size; 
    array_push($info, $temp);
    }
 
    //displaying the result in json format 
    echo json_encode($info);

?>