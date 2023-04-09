// IPersonManager.aidl
package com.android.demo;

// Declare any non-default types here with import statements
import com.android.demo.Person;

interface IPersonManager {
   void addPerson(in Person p);
   List<Person> getPerson();
}