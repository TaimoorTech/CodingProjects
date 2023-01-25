<?php

    include "dbconnect.php";

    $upload_path = "images/";
    $server_ip = gethostbyname(gethostname());
    $upload_url = "http://".$server_ip."/".$upload_path;
    
    $response = array();

    if($_SERVER["REQUEST_METHOD"]=="POST") {

        if(isset($_POST["name"]) and isset($_POST["email"]) and isset($_POST["password"]) and 
        $_FILES['image']['name']){

            if(mysqli_connect_error($conn)){
                echo "Faild to connect";
            }

            $user_name = $_POST["name"];
            $user_email = $_POST["email"];    
            $user_pass = $_POST["password"];
            $fileinfo = pathinfo($_FILES["upload"]["name"]);

            $filename = "IMG".rand().".jpg";
            $file_url = $upload_url.$filename;
            $filepath = $upload_path.$filename;




            try{

                move_uploaded_file($_FILES["image"]["tem_name"],$filepath);
                $select = mysqli_query($conn, "SELECT * FROM `User_Info` WHERE `Email` = '$user_email'");
                if(mysqli_num_rows($select)) {
                    echo 'This Email already exists' ;
                }
                else{
                    $sql = "INSERT INTO `User_Info`(`Name`, `Email`, `Password`, `Image`)
                    VALUES('$user_name','$user_email','$user_pass','$file_url')";

                    if(mysqli_query($conn,$sql)) {
                        echo "Data inserted successfully....";
                    }
                    else
                    {
                        echo "some error occured";
                    }
                    mysqli_close($conn); 

                    }

            }
            catch(Exception $e)
            {

                $response["error"] = true;
                $response["message"] = $e ->getMessage();

            }

        }
    }
    
?>