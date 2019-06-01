<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$nom=$_REQUEST['nom'];
$prenom=$_REQUEST['prenom'];
$date=$_REQUEST['dateNaiss'];
Date $dateNaiss = strtotime($date);
$sexe=$_REQUEST['sexe'];
$adresse=$_REQUEST['adresse'];
$email=$_REQUEST['email'];
$password=$_REQUEST['password'];
$role=$_REQUEST['role'];
$confirmationCode=$_REQUEST['confirmationCode'];
echo $nom.'/'.$prenom.'/'.$dateNaiss.'/'.$sexe.'/'.$adresse.'/'.$email.'/'.$password.'/'.$role.'/'.$confirmationCode;




require_once('..\connect.php'); 
//      $query_search = "INSERT INTO user (nom,prenom,dateNaiss,sexe,adresse,email,password) VALUES ('$nom','$prenom','$dateNaiss','$sexe','$adresse','$email','$password') ";  
        $query_search = "insert into user  (nom,prenom,sexe,adresse,email,password,role,confirmationCode) VALUES ('$nom','$prenom','$sexe','$adresse','$email','$password','$role','$confirmationCode') ";  
//		$query_search = "insert into user  (nom,prenom,sexe) VALUES ('TEst33','test33','Femme')";
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);	  
?>
