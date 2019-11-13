using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NunitTestExample
{
    [TestFixture]
    public class Class1
    {
        [Test]
        public void FirstTest()
        {
            Assert.AreEqual(1,1);
        }
        [Test]
        public void SecondtTest()
        {
            Assert.AreEqual(1,2);
        }

        [Test]
        [Ignore("dddd")]
        public void ThirdTest()
        {
            Assert.AreEqual(1,1);
        }

        [Test]
        public void ForthTest()
        {
            Assert.AreEqual(1,1);
        }
    }
}
