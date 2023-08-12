import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatTabGroup } from '@angular/material/tabs';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent implements OnInit, OnDestroy {
  @ViewChild('tabGroup') tabGroup!: MatTabGroup;
  intervalId: any;

  ngOnInit() {
    this.startInterval();
  }

  ngOnDestroy() {
    this.clearInterval();
  }

  startInterval() {
    this.intervalId = setInterval(() => {
      if (this.tabGroup && this.tabGroup.selectedIndex !== null) {
        const selectedIndex = (this.tabGroup.selectedIndex + 1) % this.tabGroup._tabs.length;
        this.tabGroup.selectedIndex = selectedIndex;
      }
    }, 6000); 
  }

  clearInterval() {
    clearInterval(this.intervalId);
  }

  onTabChange(newIndex: number) {
    this.clearInterval();
    this.startInterval();
  }
}
