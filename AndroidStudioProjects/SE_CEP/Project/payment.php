<?php

    include "dbconnect.php";

    $taxt_type = $_POST["tax_type"];
    $year = $_POST["year"];
    $month = $_POST["month"];
    $cardnumber = $_POST["card_number"];    
    $expirydate = $_POST["expiry_date"];
    $cvv = $_POST["cvv"];
    $name = $_POST["name"];
    $amount = $_POST["amount"];
    $date = date("d-m-Y");
    $time = date("H:i");
    

    $sql = "INSERT INTO `Transaction_History`(`Tax Type`, `Year`, `Month`, `Credit Card Number`, `CVV Code`, `Expiry Date`, `Name`, `Date`, `Time`, `Amount`)
        VALUES('$taxt_type','$year','$month','$cardnumber','$expirydate','$cvv','$name','$date','$time','$amount')";

        if(mysqli_query($conn,$sql)) {
            echo "Data inserted successfully....";
        }
        else
        {
            echo "some error occured";
        }
        mysqli_close($conn); 
    
?>