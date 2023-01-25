<?php

    include "dbconnect.php";

    $userf_name = $_POST["f_name"];
    $userl_name = $_POST["l_name"];
    $user_cnic = $_POST["cnic"];
    $user_email = $_POST["email"];    
    $user_pass = $_POST["password"];
    $user_img = $_POST["upload"];

    $upload_path = "project/User_images/";
    $server_ip = gethostbyname(gethostname());
    $upload_url = "http://".$server_ip."/".$upload_path;

    $filename = "IMG".rand().".jpg";
    file_put_contents("User_images/".$filename,base64_decode($user_img));

    $file_url = $upload_url.$filename;
    

    $select = mysqli_query($conn, "SELECT * FROM `User_Info` WHERE `Email` = '$user_email'");
    if(mysqli_num_rows($select)) {
        echo 'This Email already exists' ;
    }
    else{
        $sql = "INSERT INTO `User_Info`(`First Name`, `Last Name`, `CNIC`, `Email`, `Password`, `Image`)
        VALUES('$userf_name','$userl_name','$user_cnic','$user_email','$user_pass','$file_url')";

        if(mysqli_query($conn,$sql)) {
            echo "Data inserted successfully....";
        }
        else
        {
            echo "some error occured";
        }
        mysqli_close($conn); 
    }
     
    
    
?>