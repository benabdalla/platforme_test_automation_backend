#include <FileConstants.au3>
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>

ControlClick("Enregistrer sous","","Button2")
sleep(1000)
ControlFocus ("Confirmer l’enregistrement","","Button1")
ControlClick("Confirmer l’enregistrement","","Button1")
FileMove("C:\Users\amira.barhoumi\Documents\CrystalReportViewer1.rtf","E:\qualipro\trunk\AutomatisationTQualiPro_prod231\resources\Telechargement\", $FC_OVERWRITE )




