<?php

    include "dbconnect.php";

    $vehicle_class = $_POST["Property_Type"];
    $purchase_type = $_POST["City"];
    $ownweship_status = $_POST["Owner_Status"];
    $price = $_POST["Address"];    
    $seating_capacity = $_POST["Land_Area"];
    $import_purchase_date = $_POST["Covered_Area"];
    $engine_size = $_POST["Construction_Type"];
    

    $sql = "INSERT INTO `Vehicle_Tax`(`Vehicle Class`, `Purchase Type`, `Ownership Status`, `Price`, `Seating Capacity`, `Import/Purchase Date`, `Engine Size`)
        VALUES('$vehicle_class','$purchase_type','$ownweship_status','$price','$seating_capacity','$import_purchase_date','$engine_size')";

        if(mysqli_query($conn,$sql)) {
            echo "Data inserted successfully....";
        }
        else
        {
            echo "some error occured";
        }
        mysqli_close($conn); 
    
?>