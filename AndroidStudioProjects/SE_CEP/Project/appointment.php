<?php

    include "dbconnect.php";

    $user_name = $_POST["name"];
    $user_email = $_POST["email"];
    $user_phone = $_POST["phone_number"];
    $user_date = $_POST["date"];
    $user_time = $_POST["time"];

    

    $sql = "INSERT INTO `Appointment`(`Name`, `Email`, `Phone Number`, `Date`, `Time`)
        VALUES('$user_name','$user_email','$user_phone','$user_date','$user_time')";

        if(mysqli_query($conn,$sql)) {
            echo "Data inserted successfully....";
        }
        else
        {
            echo "some error occured";
        }
        mysqli_close($conn); 
    
?>