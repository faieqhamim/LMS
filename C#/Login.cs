using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace newForm1
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Register r = new Register();
            r.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try 
            {
                SqlConnection connection = new SqlConnection("Data Source = Localhost; Initial Catalog = Library1; Integrated Security = True");
                connection.Open();
                string query = "select * from UserInfo where UserName='"+textBox1.Text+"' and Password='"+textBox2.Text+"'";

                SqlCommand command = new SqlCommand(query, connection);

                SqlDataAdapter dataAdapter = new SqlDataAdapter(command);
                DataSet dataSet = new DataSet();
                dataAdapter.Fill(dataSet);

                DataTable dataTable = dataSet.Tables[0];

                if(dataTable.Rows.Count != 1)
                {
                    MessageBox.Show("Invalid UserName or Password");
                }
                else
                {
                    int UserID = Int32.Parse(dataTable.Rows[0]["UserID"].ToString());
                    string UserName = dataTable.Rows[0]["UserName"].ToString();
                    int UserType = Int32.Parse(dataTable.Rows[0]["UserType"].ToString());
                    

                    Connection.UserID = UserID;
                    Connection.UserName = UserName;
                    if(UserType==(int)EnumCls.UserType.Admin)
                    {
                        Admin admin = new Admin();
                        admin.Show();
                        this.Hide();
                    }
                    else if(UserType == (int)EnumCls.UserType.Manager)
                    {
                        ManagerForm managerForm = new ManagerForm();
                        managerForm.Show();
                        this.Hide();
                    }
                    else
                    {
                        Users users = new Users();
                        users.Show();
                        this.Hide();
                    }
                }
            }
            catch(Exception exception)
            {
                MessageBox.Show(exception.Message);
            }
            
        }
    }
}
