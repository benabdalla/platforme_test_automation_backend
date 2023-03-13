#include <FileConstants.au3>
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
ControlFocus ("Confirmer l’enregistrement","","Button1")
ControlClick("Enregistrer sous","","Button2")
sleep(1000)
ControlFocus ("Confirmer l’enregistrement","","Button1")
ControlClick("Confirmer l’enregistrement","","Button1")
FileMove("C:\Users\amira.barhoumi\Documents\CrystalReportViewer1.rtf","C:\Qualipro_Auto\AutomatisationTQualiPro_23\AutomatisationTQualiPro_23\resources\Telechargement\"&$sText&$iNum&".rtf", $FC_OVERWRITE )

