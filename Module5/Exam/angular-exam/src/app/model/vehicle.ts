import {Start} from "./start";
import {End} from "./end";

export interface Vehicle {
  id: number;
  type: string;
  name: string;
  start: Start;
  end: End;
  number: number;
  email :string;
  timeToStart: string;
  timeToArrive: string;

}
