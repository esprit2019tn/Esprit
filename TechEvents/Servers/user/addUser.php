<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$nom=$_REQUEST['nom'];
$prenom=$_REQUEST['prenom'];
$dateNaiss=$_REQUEST['dateNaiss'];
$sexe=$_REQUEST['sexe'];
$adresse=$_REQUEST['adresse'];
$email=$_REQUEST['email'];
$motDePasse=$_REQUEST['password'];
$role=$_REQUEST['role'];
$confirmationCode=$_REQUEST['confirmationCode'];
echo $nom.'/'.$prenom.'/'.$dateNaiss.'/'.$sexe.'/'.$adresse.'/'.$email.'/'.$motDePasse.'/'.$role.'/'.$confirmationCode;




require_once('..\connect.php'); 
        $query_search = "insert into user  (nom,prenom,dateNaiss,sexe,adresse,email,password,role,confirmationCode) VALUES ('$nom','$prenom','$dateNaiss','$sexe','$adresse','$email','$motDePasse','$role','$confirmationCode') ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);	  
?>
