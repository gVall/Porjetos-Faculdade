#ifndef TELALISTAGEM_H
#define TELALISTAGEM_H
#include <list>
#include <QFile>
#include <QTextStream>
#include <QDialog>

namespace Ui {
class TelaListagem;
}

class TelaListagem : public QDialog
{
    Q_OBJECT

public:
    explicit TelaListagem(QWidget *parent = nullptr);
    ~TelaListagem();

private slots:
    void on_pushButtonVoltar_clicked();

    void on_pushButtonListar_clicked();

private:
    Ui::TelaListagem *ui;
};

#endif // TELALISTAGEM_H
