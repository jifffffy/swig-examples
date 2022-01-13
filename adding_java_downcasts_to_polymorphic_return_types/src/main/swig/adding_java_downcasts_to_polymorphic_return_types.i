%module AddingJavaDowncastsToPolymorphicReturnTypes

%include "std_string.i"

%inline %{
    #include <iostream>
using namespace std;
class Vehicle {
public:
  virtual void start() = 0;
};

class Ambulance : public Vehicle {
  string vol;
public:
  Ambulance(string volume) : vol(volume) {}
  virtual void start() {
    cout << "Ambulance started" << endl;
  }
  void sound_siren() {
    cout << vol << " siren sounded!" << endl;
  }
};

Vehicle *vehicle_factory() {
  return new Ambulance("Very loud");
}
%}