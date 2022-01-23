using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace newForm1
{
    public partial class UpdateBookDetails : Form
    {
        SqlConnection connection = new SqlConnection("Data Source = Localhost; Initial Catalog = Library1; Integrated Security = True");
        public UpdateBookDetails()
        {
            InitializeComponent();
        }

        private void UpdateBookDetails_Load(object sender, EventArgs e)
        {
            disp_Books();
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int i;
            i = Convert.ToInt32(dataGridView1.SelectedCells[0].Value.ToString());
            try
            {
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "select * from BookDetail where BookID = '+i+'";
                command.ExecuteNonQuery();
                DataTable dataTable = new DataTable();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);

                dataAdapter.Fill(dataTable);
                
               
                foreach(DataRow dataRow in dataTable.Rows)
                {
                    BookName.Text = dataRow["BookName"].ToString();
                    AuthorName.Text = dataRow["BookAuthor"].ToString();
                    PublicationName.Text = dataRow["BookPublicationName"].ToString();
                    PublicationYear.Text = dataRow["PublicationDate"].ToString();
                    ISBN.Text = dataRow["ISBN"].ToString();
                    BookPrice.Text = dataRow["BookPrice"].ToString();
                    BookQuantity.Text = dataRow["BookQuantity"].ToString();
                }
                connection.Close();



            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            int i;
            i = Convert.ToInt32(dataGridView1.SelectedCells[0].Value.ToString());
            try
            {
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "update BokkDetail set BookName = '"+BookName.Text+"',BookAuthor'"+AuthorName.Text+"',BookPublicationName'"+PublicationName.Text+"',BookPublicationDate'"+PublicationYear.Text+"','ISBN"+ISBN.Text+"','BookPrice"+BookPrice.Text+"','BookQuantity"+BookQuantity.Text+"' where BookID = '+i+' ";
                command.ExecuteNonQuery();
                DataTable dataTable = new DataTable();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);

                dataAdapter.Fill(dataTable);
                dataGridView1.DataSource = dataTable;
                ///MessageBox.Show("Book is Added to the Book List");
                connection.Close();
            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }
        }
        public void disp_Books()
        {
            try
            {
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "select * from BookDetail";
                command.ExecuteNonQuery();
                DataTable dataTable = new DataTable();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);

                dataAdapter.Fill(dataTable);
                dataGridView1.DataSource = dataTable;
                ///MessageBox.Show("Book is Added to the Book List");
                connection.Close();
            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }
        }
    }
}
