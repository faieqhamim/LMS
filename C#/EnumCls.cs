using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace newForm1
{
    static class EnumCls
    {
      public enum Status
       {
            PendingRequest = 0,
            Cleared = 1,
            PendingBook = 2,
            Approved = 3 ,
            Canceled = 4 ,
            Active = 5

       }
        public enum UserType
        {
            Admin = 0,
            Manager = 1,
            Users = 2,
           

        }
    }
}
