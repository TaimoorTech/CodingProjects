<?php

    include "dbconnect.php";
    
    $useremail = $_POST["email"];
    $password = $_POST["password"];

    
    $query = "SELECT * FROM User_Info WHERE `Email`='$useremail' AND `Password`='$password'";
      
    
    $result = mysqli_query($conn, $query);
    
    $count = mysqli_num_rows($result);
      

    if($count>0){
        echo "Signing in";
        $stmt = $conn->prepare("SELECT `First Name`, `Email`, `CNIC`, `Number` FROM `User_Info`");

//executing the query 
$stmt->execute();

//binding results to the query 
$stmt->bind_result($name,$email,$cnic,$number);

$products = array(); 
$products['data'] = array();

//traversing through all the result 
while($stmt->fetch()){
$temp = array();
$temp['name'] = $name;
$temp['email'] = $email;
$temp['cnic'] = $cnic;
$temp['number'] = $number;

array_push($products['data'], $temp);
}

//displaying the result in json format 
echo json_encode($products);
    }
    else {
       echo "Your Login Name or Password is invalid";
    }
    

?>