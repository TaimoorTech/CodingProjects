<?php 

    include "dbconnect.php";
 
    //Checking if any error occured while connecting
    if (mysqli_connect_errno()) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    die();
    }

    $user_email = $_POST["email"];
    
        $stmt = $conn->prepare("SELECT `user_id`, `Date`, `Time`,  `Method`, `Amount` FROM `transaction_history` JOIN `User_Info` 
        ON transaction_history.user_id = User_Info.id WHERE User_Info.Email ='$user_email'");
        
        //executing the query
        $stmt->execute();
        
        //binding results to the query 
        $stmt->bind_result($id, $date, $time, $method, $amount);
        
        $info = array(); 
        
        //traversing through all the result
        while($stmt->fetch()){
            $temp = array();
            $temp['user_id'] = $id;
            $temp['date'] = $date;
            $temp['time'] = $time;
            $temp['method'] = $method;
            $temp['amount'] = $amount;
            array_push($info, $temp);
        }
        
        //displaying the result in json format
        echo json_encode($info);

?>