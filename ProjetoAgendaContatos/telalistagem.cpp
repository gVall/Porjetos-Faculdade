#include "telalistagem.h"
#include "ui_telalistagem.h"

#include <QMessageBox>

TelaListagem::TelaListagem(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::TelaListagem)
{
    ui->setupUi(this);

}

TelaListagem::~TelaListagem()
{
    delete ui;
}

void TelaListagem::on_pushButtonVoltar_clicked()
{
    this->close();
}



void TelaListagem::on_pushButtonListar_clicked()
{
    try
    {
        QFile file("AgendaCliente.txt");
        file.open(QIODevice::ReadOnly);
        QTextStream entrada(&file);
        QList<QStringList> lista;
        QString line;
        do
        {
            line = entrada.readLine();
            lista.append(line.split(";"));
        } while (!line.isNull());

        ui->tableWidget->setRowCount(lista.size());
        ui->tableWidget->setColumnCount(lista[0].size() + 1);

        for (int linha = 0; linha < lista.size() - 1; linha++)
        {
            for (int coluna = 0; coluna < lista[linha].size(); coluna++)
            {
                ui->tableWidget->setItem(linha, coluna, new QTableWidgetItem(lista[linha][coluna]));
            }

            QString p = ui->tableWidget->item(linha, 8)->text();

            QTableWidgetItem *foto = new QTableWidgetItem();
//            foto->setIcon(QIcon(path));
//            ui->tableWidget->setItem(linha, 9, foto);

            QPixmap pix = QPixmap(p).scaled(32, 32, Qt::KeepAspectRatio, Qt::SmoothTransformation);
                foto->setData(Qt::DecorationRole, pix);
                ui->tableWidget->setItem(linha, 9, foto);


        }

    }
    catch (QString &erro)
    {
        QMessageBox::information(this,"ERRO", erro);
    }

}
