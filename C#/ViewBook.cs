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
    public partial class ViewBook : Form
    {
        SqlConnection connection = new SqlConnection("Data Source = Localhost; Initial Catalog = Library1; Integrated Security = True");
        public ViewBook()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_KeyUp(object sender, KeyEventArgs e)
        {

            int i = 0;
            try
            {
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "select * from BookDetail where BookName like ('%" + textBox1.Text + "%')";
                command.ExecuteNonQuery();
                DataTable dataTable = new DataTable();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);

                dataAdapter.Fill(dataTable);

                i = Convert.ToInt32(dataTable.Rows.Count.ToString());
                dataGridView1.DataSource = dataTable;

                if (i == 0)
                {
                    MessageBox.Show("Book Name is no found in the Book List");
                }
                ///MessageBox.Show("Book is Added to the Book List");
                connection.Close();
            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            int i = 0;
            try
            {
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "select * from BookDetail where BookAuthor like ('%" + textBox2.Text + "%')";
                command.ExecuteNonQuery();
                DataTable dataTable = new DataTable();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);

                dataAdapter.Fill(dataTable);

                i = Convert.ToInt32(dataTable.Rows.Count.ToString());
                dataGridView1.DataSource = dataTable;

                if (i == 0)
                {
                    MessageBox.Show("Author Name is no found in the Book List");
                }
                ///MessageBox.Show("Book is Added to the Book List");
                connection.Close();
            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            int i = 0;
            try
            {
                connection.Open();
                SqlCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "select * from BookDetail where BookPublicationName like ('%" + textBox3.Text + "%')";
                command.ExecuteNonQuery();
                DataTable dataTable = new DataTable();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);

                dataAdapter.Fill(dataTable);

                i = Convert.ToInt32(dataTable.Rows.Count.ToString());
                dataGridView1.DataSource = dataTable;

                if (i == 0)
                {
                    MessageBox.Show("Publication Name is no found in the Book List");
                }
                ///MessageBox.Show("Book is Added to the Book List");
                connection.Close();
            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }
        }

        private void ViewBook_Load(object sender, EventArgs e)
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
