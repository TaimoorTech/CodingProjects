<?php 

    include "dbconnect.php";
 
    //Checking if any error occured while connecting
    if (mysqli_connect_errno()) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    die();
    }

 
    //creating a query
    $stmt = $conn->prepare("SELECT `Id`, `Property Type`, `City`, `Address`, `Land Area`,
    `Covered Area`, `Construction Type` FROM `Property_Tax`");
 
    //executing the query 
    $stmt->execute();
 
    //binding results to the query 
    $stmt->bind_result($id, $property_type, $city, $address, 
    $land_area, $covered_area, $construction_type);
 
    $info = array(); 
 
    //traversing through all the result 
    while($stmt->fetch()){
    $temp = array();
    $temp['id'] = $id; 
    $temp["property_type"] = $property_type;
    $temp["city"] = $city;
    $temp["address"] = $address;
    $temp["land_area"] = $land_area;
    $temp["covered_area"] = $covered_area;    
    $temp["construction_type"] = $construction_type;
    array_push($info, $temp);
    }
 
    //displaying the result in json format 
    echo json_encode($info);

?>