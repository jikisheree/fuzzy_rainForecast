public class Membership_function {

    public final double wind_function1(String type, double wind_input){

        // input between 0.07-4.41

        double membership = 0.0;
        switch (type){
            case "nl":
                if(wind_input>=0.07 && wind_input<=0.1)
                    membership = 33.33*wind_input-2.33;
                else if(wind_input>=0.1 && wind_input<=0.49)
                    membership = -2.56*wind_input+1.26;
                else
                    membership = 0;
                break;
            case "ns":
                if(wind_input>=0.47 && wind_input<=0.85)
                    membership = 2.63*wind_input-1.24;
                else if(wind_input>=0.85 && wind_input<=1.23)
                    membership = -2.63*wind_input+3.24;
                else
                    membership = 0;
                break;
            case "ze":
                if(wind_input>=1.17 && wind_input<=1.54)
                    membership = 2.7*wind_input-3.16;
                else if(wind_input>=1.54 && wind_input<=2.14)
                    membership = -1.67*wind_input+3.56;
                else
                    membership = 0;
                break;
            case "ps":
                if(wind_input>=2.04 && wind_input<=3.23)
                    membership = 0.84*wind_input-1.71;
                else if(wind_input>=3.23 && wind_input<=4.41)
                    membership = -0.85*wind_input+3.74;
                else
                    membership = 0;
                break;
        }

        return membership;

    }

    public final double temp_function1(String type, double temp_input){

        //input between 15-38

        double membership = 0.0;
        switch (type){
            case "poor":
                if(temp_input>=15 && temp_input<=20.5)
                    membership = 0.18*temp_input-2.73;
                else if(temp_input>=20.5 && temp_input<=23)
                    membership = -0.4*temp_input+9.2;
                else
                    membership = 0;
                break;
            case "low":
                if(temp_input>=19.5 && temp_input<=23)
                    membership = 0.29*temp_input-5.57;
                else if(temp_input>=23 && temp_input<=27.5)
                    membership = -0.22*temp_input+6.1;
                else
                    membership = 0;
                break;
            case "med":
                if(temp_input>=24 && temp_input<=29)
                    membership = 0.2*temp_input-4.8;
                else if(temp_input>=29 && temp_input<=34)
                    membership = -0.2*temp_input+6.8;
                else
                    membership = 0;
                break;
            case "high":
                if(temp_input>=30 && temp_input<=34)
                    membership = 0.25*temp_input-7.5;
                else if(temp_input>=34 && temp_input<=48)
                    membership = -0.25*temp_input+9.5;
                else
                    membership = 0;
                break;
        }

        return membership;
    }

    public final double humid_function1(String type, double humid_input){

        // input between 60-100

        double membership = 0.0;
        switch (type){
            case "poor":
                if(humid_input>=60 && humid_input<=76.5)
                    membership = 0.12*humid_input-7.27;
                else if(humid_input>=0.1 && humid_input<=0.49)
                    membership = -0.12*humid_input+9.27;
                else
                    membership = 0;
                break;
            case "low":
                if(humid_input>=71 && humid_input<=86)
                    membership = 0.125*humid_input-9.5;
                else if(humid_input>=15 && humid_input<=25)
                    membership = -0.14*humid_input+12.29;
                else
                    membership = 0;
                break;
            case "med":
                if(humid_input>=81 && humid_input<=94.5)
                    membership = 0.14*humid_input-12.6;
                else if(humid_input>=25 && humid_input<=35)
                    membership = -0.15*humid_input+14.54;
                else
                    membership = 0;
                break;
            case "high":
                if(humid_input>=88 && humid_input<=100)
                    membership = 0.17*humid_input-14.67;
                else if(humid_input>=35 && humid_input<=45)
                    membership = -0.17*humid_input+15.67;
                else
                    membership = 0;
                break;
        }

        return membership;
    }
}
