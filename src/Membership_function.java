public class Membership_function {

    public final double wind_function1(String type, double wind_input){
        double membership = 0.0;
        switch (type){
            case "nl":
                if(wind_input>=1 && wind_input<=3)
                    membership = -0.5*wind_input+1.5;
                else
                    membership = 0;
                break;
            case "ns":
                if(wind_input>=1 && wind_input<=3)
                    membership = 0.5*wind_input-0.5;
                else if(wind_input>=3 && wind_input<=5)
                    membership = -0.5*wind_input+2.5;
                else
                    membership = 0;
                break;
            case "ze":
                if(wind_input>=3 && wind_input<=5)
                    membership = 0.5*wind_input-1.5;
                else if(wind_input>=5 && wind_input<=7)
                    membership = -0.5*wind_input+3.5;
                else
                    membership = 0;
                break;
            case "ps":
                if(wind_input>=5 && wind_input<=7)
                    membership = 0.5*wind_input-2.5;
                else if(wind_input>=7 && wind_input<=9)
                    membership = -0.5*wind_input+4.5;
                else
                    membership = 0;
                break;
            case "pl":
                if(wind_input>=7 && wind_input<=9)
                    membership = 0.5*wind_input-3.5;
                else
                    membership = 0;
        }

        return membership;

    }

    public final double temp_function1(String type, double temp_input){
        double membership = 0.0;
        switch (type){
            case "nl":
                if(temp_input>=5 && temp_input<=15)
                    membership = -0.1*temp_input+1.5;
                else
                    membership = 0;
                break;
            case "ns":
                if(temp_input>=5 && temp_input<=15)
                    membership = 0.1*temp_input-0.5;
                else if(temp_input>=15 && temp_input<=25)
                    membership = -0.1*temp_input+2.5;
                else
                    membership = 0;
                break;
            case "ze":
                if(temp_input>=15 && temp_input<=25)
                    membership = 0.1*temp_input-1.5;
                else if(temp_input>=25 && temp_input<=35)
                    membership = -0.1*temp_input+3.5;
                else
                    membership = 0;
                break;
            case "ps":
                if(temp_input>=25 && temp_input<=35)
                    membership = 0.1*temp_input-2.5;
                else if(temp_input>=35 && temp_input<=45)
                    membership = -0.1*temp_input+4.5;
                else
                    membership = 0;
                break;
            case "pl":
                if(temp_input>=35 && temp_input<=45)
                    membership = 0.1*temp_input-3.5;
                else
                    membership = 0;
        }

        return membership;
    }
}
