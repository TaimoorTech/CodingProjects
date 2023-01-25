<?php

    include "dbconnect.php";

    $property_type = $_POST["Property_Type"];
    $city = $_POST["City"];
    $address = $_POST["Address"];
    $land_area = $_POST["Land_Area"];    
    $covered_area = $_POST["Covered_Area"];
    $construction_type = $_POST["Construction_Type"];
    

    $sql = "INSERT INTO `Property_Tax`(`Property Type`, `City`, `Address`, `Land Area`, `Covered Area`, `Construction Type`)
        VALUES('$property_type','$city','$address','$land_area','$covered_area','$construction_type')";

        if(mysqli_query($conn,$sql)) {
            echo "Data inserted successfully....";
        }
        else
        {
            echo "some error occured";
        }
        mysqli_close($conn); 
    
?>