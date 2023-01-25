<?php

    include "dbconnect.php";

    $user_email = $_POST["email"];    
    $user_pass = $_POST["password"];
    
    
    $select = mysqli_query($conn,"SELECT * FROM `User_Info` WHERE `Email`='$user_email'");
    if(mysqli_num_rows($select)){

        $query = mysqli_query($conn,"UPDATE `User_Info` SET `Password` = '$user_pass' WHERE `Email`='$user_email'");

        echo "Data Updated successfully....";

    }
    else{
        
        echo "No such user";
    }
    mysqli_close($conn);

?>