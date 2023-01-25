<?php

    include "dbconnect.php";

    $make = $_POST["make"];
    $modal = $_POST["modal"];    
    $user_img = $_POST["upload"];

    $upload_path = "project/Car_images/";
    $server_ip = gethostbyname(gethostname());
    $upload_url = "http://".$server_ip."/".$upload_path;

    $filename="IMG".rand().".png";
    file_put_contents("Car_images/".$filename,base64_decode($user_img));

    $file_url = $upload_url.$filename;
    
    
    $sql = "INSERT INTO `vehicle_inventory`(`Make`, `Modal`, `Image`)
    VALUES('$make','$modal','$file_url')";
     
    if(mysqli_query($conn,$sql))    
    {    
        echo "Data inserted successfully....";    
    }    
    else     
    {    
        echo "some error occured";    
    }    
    mysqli_close($conn); 
    
    
?>