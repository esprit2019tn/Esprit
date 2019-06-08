<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$email=$_REQUEST['email'];
echo $email;

require_once('..\connect.php'); 
			 $query_search ="UPDATE user SET active =1 where email='"+email+"'";
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);	  
?>
