#include <date.au3>
$date = StringReplace(_NowDate(), "/", "")
ControlFocus ("Ouvrir","","Edit1")
Global $Num = Random(0,1163,1)
Global $pathdoc ="E:\qualipro\trunk\AutomatisationTQualiPro_prod231\resources\pieces_jointes\" & $Num  & $date & ".docx"
FileCopy("E:\qualipro\trunk\AutomatisationTQualiPro_prod231\resources\pieces_jointes\Doc_Test 2x.docx",$pathdoc)
ControlSetText ("Ouvrir","","Edit1",$pathdoc)
ControlClick ("Ouvrir","","Button1")